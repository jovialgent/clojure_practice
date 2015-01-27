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
    (even-sum L)
    "\n"
  )
  (print
    "TEST FOR IN CLASS MY-MAX:"
    (my-max L)
    "\n"
  )
  (print
    "TEST FOR IN CLASS MY-MAX 2:"
    (my-max2 L)
    "\n"
  )
)

(run_my_tests '(1 2 3 4 5 6 7 8 9))