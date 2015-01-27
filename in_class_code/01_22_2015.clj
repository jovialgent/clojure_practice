;@author : George Petersen
;@file : code_notes_01_22_2015.clj

(defn eyear? 
  [yr] 
  (= (mod yr 4) 0))

(print (filter (fn [yr] (= (mod yr 4) 0)) [2004, 2008, 2016, 2020]) \newline)


;In Class Practice

(defn my-sum2
  [L]
  (if (empty? L)
    0
    (+ (first L) (my-sum2 (rest L)))))

(print (my-sum2 '(1 2 3)) \newline)

(defn my-sum3
  [L]
  (if (empty? L)
    ;if list is empty add zero and close
    0
    
    ; if there is an element, get the first element,
    ; which is a list and take that list's first element
    ; which is a number and sum them. 
    (+ (first (first L))
       (my-sum3 (rest L))
    )
  )
)

(pp (my-sum3 '((1 Anne) (2 Frank) (3 Stew))) \newline)