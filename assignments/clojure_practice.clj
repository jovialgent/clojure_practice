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
; @return: the max value in a list or -1 if empty


(defn my-max
  [L] ; list of numbers

  ; If the list is empty return -1, else begin the 
  ; recursive calls to find max
  (if (empty? L)
   -1
   
    ; If the list has one element, return it as its max,
    ; else compare the elements in a list
   (if (= (count L) 1)
     (first L)
     
     ; if the first of the list is bigger than the second of the
     ; list, call my-max on the list without its second element. Else,
     ; call my-max on the list without its first element.
     (if (> (first L) (first (rest L)))
       (my-max (conj (rest (rest L)) (first L)))
       (my-max (rest L))
     ) 
   ))) ; End of my-max


; Takes a list of numbers and adds only the numbers that 
; even numbers in the list.
; @function: even-sum
; @arguments: L - list of numbers
; @return: the sum of all even numbers

(defn even-sum
  [L] ;list of numbers
  
  ; If list is empty, return 0
  (if (empty? L)
    0
    
    ; If the first element is even, add it to the sum,
    ; else add zero and continue the recursive call.
    (if (= (mod (first L) 2) 0)
        (+ (first L) (even-sum (rest L)))
        (+ 0 (even-sum (rest L)))
    )
  )); End of even-sum


; ***********************
; * Tests for Functions *
; ***********************

; ------------
; my-max tests
; ------------

(print "*** Start of my-max Tests ***\n" \newline)

; Test 1: If list is empty return -1
(print "Empty list return -1: "(= (my-max '()) -1)\newline)

; Test 2: If list is '(4) then return 4
(print "List length is one, return first element: " (= (my-max '(4)) 4) \newline)

; Test 3: In list (2 7 3 11 5 1 6) return 11
(print "In a list '(2 7 3 11 5 1 6), it should return 11: " (= (my-max '(2 7 3 11 5 1 6)) 11) \newline \newline)


(print "*** End of my-max Tests ***" \newline \newline)

; --------------
; even-sum Tests
; --------------

(print "*** Start of even-sum Tests ***\n" \newline)

; If list is empty return 0

(print "Returns 0 if list is empty: " (= (even-sum '()) 0) \newline)

; Tests to see if the answer to the problem is even since all even
; numbers add up are even.
(print "Returns an even number: " (= (mod (even-sum '(1 2 3 4)) 2) 0) \newline)

; Test to see if list is all odd it return 0
(print "Returns 0 if list is all odd numbers: " (= (even-sum '(1 3 5 7 9)) 0) \newline)

; If the list is '(2 7 3 11 5 1 6) then it should return 8
(print "Returns 8 if list is '(2 7 3 11 5 1 6): " (= (even-sum '(2 7 3 11 5 1 6)) 8) \newline \newline)

(print "*** End of even-sum Tests ***"\newline\newline)

; --------------
; all-pos? Tests
; --------------

(print "*** Start of all-pos? Tests ***\n" \newline)

(print "*** End of all-pos? Tests ***"\newline\newline)

