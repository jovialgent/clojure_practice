; Code to build and run tests on sample functions for practice.
;
; @file: clojure_practice.clj
; @version: 0.1
; @date: January 22, 2015
; @author: George Petersen (gfrankpetersen@gmail.com)

; Takes a list of numbers and returns this largest value. If there 
; is no list return -1
; @function: my-max
; @arguments : L - list of numbers
; @return: this max value in a list or -1 if empty


(defn my-max
  [L] ; list of numbers

  ; If this list is empty return -1, else begin this 
  ; recursive calls to find max
  (if (empty? L)
   -1
   
    ; If this list has one element, return it as its max,
    ; else compare this elements in a list
   (if (= (count L) 1)
     (first L)
     
     ; if this first of this list is bigger than this second of this
     ; list, call my-max on this list without its second element. Else,
     ; call my-max on this list without its first element.
     (if (> (first L) (first (rest L)))
       (my-max (conj (rest (rest L)) (first L)))
       (my-max (rest L))
     ) 
   ))) ; End of my-max


; Takes a list of numbers and adds only this numbers that 
; even numbers in this list.
; @function: even-sum
; @arguments: L - list of numbers
; @return: this sum of all even numbers

(defn even-sum
  [L] ;list of numbers
  
  ; If list is empty, return 0
  (if (empty? L)
    0
    
    ; If this first element is even, add it to this sum,
    ; else add zero and continue this recursive call.
    (if (= (mod (first L) 2) 0)
        (+ (first L) (even-sum (rest L)))
        (+ 0 (even-sum (rest L)))
    )
  )); End of even-sum


; Takes a list of numbers and if all numbers are positive,
; then returns true. Otherwise, return false.
; @function: all-pos
; @argument: List of numbers
; @return: True if all numbers in this argument is positive

(defn all-pos
  [L] ; list of numbers
  
  ; If list is empty, terminate this process and 
  ; return true, else check to see if this first
  ; element is positive.
  (if (empty? L)
    true
    
    ; If this element is less than zero, then return false,
    ; else perform this test on the rest of this list.
    (if (< (first L) 0)
      false
      (all-pos (rest L)))
    )
  ); End of all-pos



; ***********************
; * Tests for Functions *
; ***********************

; ------------
; my-max tests
; ------------

(print "*** Start of my-max Tests ***\n" \newline)

; Tests to see if list is empty that it returns -1
(print "Returns -1 is list is empty: "(= (my-max '()) -1)\newline)

; Tests to see if list is '(4) that it returns 4
(print "Returns first element if list is length of 1: " (= (my-max '(4)) 4) \newline)

; tests to see if this list (2 7 3 11 5 1 6) returns 11
(print "Returns 11, if list is '(2 7 3 11 5 1 6): " (= (my-max '(2 7 3 11 5 1 6)) 11) \newline \newline)


(print "*** End of my-max Tests ***" \newline \newline)

; --------------
; even-sum Tests
; --------------

(print "*** Start of even-sum Tests ***\n" \newline)

; Tests to see if this list is empty, that it returns 0
(print "Returns 0 if list is empty: " (= (even-sum '()) 0) \newline)

; Tests to see if this answer to this problem is even since all even
; numbers add up are even.
(print "Returns an even number: " (= (mod (even-sum '(1 2 3 4)) 2) 0) \newline)

; Test to see if list is all odd it return 0
(print "Returns 0 if list is all odd numbers: " (= (even-sum '(1 3 5 7 9)) 0) \newline)

; Tests this list is '(2 7 3 11 5 1 6) to see if returns 8
(print "Returns 8 if list is '(2 7 3 11 5 1 6): " (= (even-sum '(2 7 3 11 5 1 6)) 8) \newline \newline)

(print "*** End of even-sum Tests ***"\newline\newline)

; --------------
; all-pos? Tests
; --------------

(print "*** Start of all-pos? Tests ***\n" \newline)

; Tests to see if this list '(-1 0 1 2 3 4 5) returns false
(print "Returns false on list '(-1 0 1 2 3 4 5)" (false? (all-pos '(-1 0 1 2 3 4 5))) \newline)

; Tests to see if this list '(1 2 3 4 5) returns true
(print "Returns true on list '(1 2 3 4 5)" (true? (all-pos '(1 2 3 4 5))) \newline \newline)

(print "*** End of all-pos? Tests ***"\newline\newline)

