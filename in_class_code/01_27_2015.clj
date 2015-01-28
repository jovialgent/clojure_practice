(defn even-sum
  [L]
  (cond   (empty? L) 
        	0
          (even? (first L)) 
          	(+ (first L) (even-sum (rest L)))
          true 
          	(+ 0 (even-sum (rest L)))
  )
)

(defn my-max
  [L]
  (cond
    (empty? L) -1
    (> (first L) (my-max (rest L))) (first L)
    true (my-max (rest L))
  )
)

(defn my-max2 [L]
  (if (empty? L) -1
  	(let [me (first L)
        others (my-max2 (rest L))]
        (if (> me others) 
          me 
          others
        )
  	)
  )
)

(defn run_my_tests 
  [L]
  (print 
    "TEST FOR IN CLASS EVEN-SUM:", 
    ;(even-sum L)
    "\n"
  )
  (print
    "TEST FOR IN CLASS MY-MAX:"
    ;(my-max L)
    "\n"
  )
  (print
    "TEST FOR IN CLASS MY-MAX 2:"
    (my-max2 L)
    "\n"
  )
)

(run_my_tests (range 30))


(defn run-notes-test
  []
	; Composing Funtions
	; '(("Fred" 1993) ("Sue" 1995))
	; Get year:
	; (first (rest (first L))) = ((comp first rest first) L)

	(print 
  		(= ((comp first rest first) '(("Fred" 1993) ("Sue" 1995))) 1993)
   		"\n"
	)
 
 	(print
        (* 2 1/3)
        "\n"
    )
  
  (print )
)

(run-notes-test)

; 3 Phrases
; 1) Read-Time
; 2) Compile-Time
; 3) Run-Time
;
; Data = Code = Data
; 
; (a b c) <---- Run function a with args b and c
; '(a b c) <--- the list a,bc <--- ' means don't evaluate
;
; Character literals = \[Character Thing]
;
; strings: "{{String}}" or (string char1 char2 .... )
;
; lists - linked list <---- '(a b c) or (list a b c)
;
; #'name = Variable Name 
;
; anonymous #(expression) %1 %2 for args
;
; Data:
;
; Symbols: 
;
; convention: word[hyphen]word
; keywords: with a colon ( :red :width :sunday)
;
; types: numbers, boolean, string, ratio, collections
; collections:
;
; -lists
; -vectors
; -set
; -map
; - All Collections:
;	- immutable (can't change)
;		-(def l1 '("hello" 7 true (a b c))) <---- Can't change
;	-heterogeneous
;		- elements can be whatever mother fuckers!
; 	- persistent
;		-
; -functions
; 	-count: count all elements
;	-conj: adds items to a list depending on the data type
;		--Lists vs. Vectors
;			-Vectors: Adds to the end not at beginning
;			-Lists: Adds to the beginning
;	-reverse: reverses the list
;	-map: applies first arg, a function, to corresponding elements
;		-(map + [1 2 3] [4 5 6] [7 8 9]) = [12, 15, 17]
;		-(map #(+ % 3) [2 4 7])
;	-butlast: returns all but the last item
;	-drop-last: returns all but n last items
;	-filter: returns collection items that pass the filer
;	Lists
;	Create - (list "steve" "bill" "sergey") = ("steve" "bill" "sergey")
;	Removing - (remove boolean-func list)
;	Joining - (into '(1 2 3 4) '(5 6 7 8))
;	Use as stack: peek, pop
;	Vectors:
;	Sets:
;	Create





