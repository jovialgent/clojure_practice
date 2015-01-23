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
   (+ 3 4)))


; Tests for my-max

; Test 1: If list is empty return -1
(print "My Max Test 1" (= (my-max '()) -1) \newline)

; Test 2: In list (2 7 3 11 5 1 6) return 11
(print "My Max Test 2" (= (my-max '(2 7 3 11 5 1 6)) 11) \newline)