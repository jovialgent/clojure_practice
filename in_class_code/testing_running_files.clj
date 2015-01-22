(defn average
  [numbers]
  (/ (apply + numbers)(count numbers)))

(print "Average: " (average [60 80 100 400]) \newline)