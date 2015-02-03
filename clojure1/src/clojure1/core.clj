(ns clojure1.core)


;; Helper Functions

(defn has-el?
  [el L]
  (cond 
    (empty? L) false
    (= el (first L)) true
  	true (has-el? el (rest L))))

(defn invert-helper
  [L i]
  (cond 
    (empty? L) '()
    (odd? i) (cons (first L) (invert-helper (rest L) (+ i 1)))
    (even? i) (cons 
                (first (rest L)) 
                (invert-helper (cons (first L) (rest (rest L))) (+ i 1)))))

(defn mcons-helper
  [L]
  (cond 
    (and (empty? (rest L)) (not (list? (first L)))) (cons (first L) '())
    (empty? (rest L)) (first L)
    true (cons (first L) (mcons-helper (rest L)))))


(defn delete-at
  "Takes a list and an index and deletes this element in this list."
  [L i]
  (cond (< i 0) L
        (= i 0) (rest L)
        true (cons (first L)  (delete-at (rest L) (- i 1)) )))

; Write a Clojure function delete-all-at which takes as arguments a list and one or more integers and 
; returns the list with the high-level elements at all the locations (zero-based indexing) 
; deleted. You can assume the integers are in ascending order. Example: (delete-all-at 
; '(a b c d e) 0 1 3) should return (c e)

(defn delete-all-at
  [L & args]  
  (cond
    (not (coll? (first args))) 
    	(cond
       		(nil? args) L
       		(not (not-any? neg? args)) L
       		(not (not-any? zero? args)) (delete-all-at (rest L) (map #(- % 1) args)))
     (coll? (first args)) 
     	(let [args-temp (first args)]
        	(cond
             	(not (not-any? zero? args-temp)) (delete-all-at (rest L) (map #(- % 1) args-temp))
           		(every? neg? args-temp) L
              	true (cons (first L) (delete-all-at (rest L) (map #(- % 1) args-temp))))))
) 



; Write the Clojure function similar that takes two lists as arguments and returns a list of the high-level elements that 
; are in both lists. For example: (similar '(a b c d e) '( x (a c) b r l)) should return (b)

(defn similar
  	[L1 L2]
   (cond
     (or (nil? L1) (nil? L2)) '()
     (or (empty? L1) (empty? L2)) '()
     (has-el? (first L1) L2) (cons (first L1) (similar (rest L1) L2))
     true (similar (rest L1) L2)
))

; Write the Clojure function alone that takes two lists as arguments and returns a list of the high-level elements 
; that are in one or the other but not in both lists. For example: (alone '(a b c d e) '( x (a c) b r l)) 
; should return (a c d e x (a c) r l)

(defn remove-el
  [el L]
  (cond 
    (empty? L) '()
    (= el (first L)) (rest L)
    true (cons (first L)  (remove-el el (rest L)))
  ))


   
(defn alone
  	[L1 L2]
   (cond
     (or (nil? L1) (nil? L2)) '()
     (or (empty? L1)) L2
     (has-el? (first L1) L2)  (alone (rest L1) (remove-el (first L1) L2))
     true (cons (first L1) (alone (rest L1) L2))
))



; Write a version of cons called mcons that takes any number of arguments. The penultimate argument 
; should be consed into the last; the one before that should be consed into the resulting value and so on.
; For example, (mcons 'a 'b 'c '(d e)) should return (a b c d e).




(defn mcons
  [& args]   
    (cond 
      (empty? args) '()
      true (mcons-helper args)
    )  
  )



; Write the Clojure function invert that takes one parameter, a list with an even-number of elements, and 
; returns the list with each pair of elements swapped. For example: (invert '(a b c d e f g h)) 
; should return (b a d c f e h g).


(defn invert
  [L]     
   (cond
     (empty? L) '()
     (odd? (count L)) -1
     true (invert-helper L 0)))



            
