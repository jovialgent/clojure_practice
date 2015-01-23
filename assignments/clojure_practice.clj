; For practice (not to turn in) write the following functions recursively.

; my-max - my-max takes a list of numbers and returns the largest value in the list. If the list is empty, my-max returns -1.
; Example:
; (my-max '(2 7 3 11 5 1 6))
; 11

; even-sum - even-sum takes a list of numbers and returns the sum of the even values.
; Example:
; (even-sum '(2 7 3 11 5 1 6))
; 8

; all-pos? - all-pos? takes a list of numbers and returns true if all values are positive and false otherwise.
; Example:
; (all-pos? '(2 7 3 11 5 1 6))
; true

; Due (the start of class) on Tuesday, 1/27/2015

; Takes a list of numbers and returns the largest value. If there 
; is no list return -1
; @function: my-max
; @arguments : L - list of numbers
; @return: return the max value in a list or -1 if empty


(defn my-max
  [L]
  (if (empty? L)
    ;returns if list is empty
   -1
   (if (= (count L) 1)
     (first L)
     (if (> (first L) (first (rest L)))
       (my-max (conj (rest (rest L)) (first L)))
       (my-max (rest L))
     )
   )))


; Tests for my-max
(print "*** Start of my-max Tests ***\n" \newline)

; Test 1: If list is empty return -1
(print "Empty list return -1: "(= (my-max '()) -1)\newline)

; Test 2: If list is '(4) then return 4
(print "List length is one, return first element: " (= (my-max '(4)) 4) \newline)

; Test 3: In list (2 7 3 11 5 1 6) return 11
(print "In a list '(2 7 3 11 5 1 6), it should return 11: " (= (my-max '(2 7 3 11 5 1 6)) 11) \newline \newline)


(print "*** End of my-max Tests ***"\newline\newline)

; Tests for even-sum
(print "*** Start of even-sum Tests ***\n" \newline)

(print "*** End of even-sum Tests ***"\newline\newline)

; Tests for all-pos?
(print "*** Start of all-pos? Tests ***\n" \newline)

(print "*** End of all-pos? Tests ***"\newline\newline)

