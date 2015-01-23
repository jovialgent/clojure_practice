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
    0
    (+ 
       (first 
        (first L))
      (my-sum3 
        (rest L)
        )
      )
    )
  )

(print (my-sum3 '((1 Anne) (2 Frank) (3 Stew))) \newline)