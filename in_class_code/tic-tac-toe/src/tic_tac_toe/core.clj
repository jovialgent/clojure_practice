(ns tic-tac-toe.core)

(def board {0 " " 1 " " 2 " " 3 " " 4 " " 5 " " 6 " " 7 " " 8 " "})
(def counter 0)

(defn is-winner? [who] 
	(or (= who (board 0) (board 1) (board 2))
		(= who (board 0) (board 3) (board 6))
		(= who (board 0) (board 4) (board 8))
		(= who (board 4) (board 1) (board 7))
		(= who (board 5) (board 8) (board 2))
		(= who (board 3) (board 4) (board 5))
		(= who (board 6) (board 7) (board 8))
		(= who (board 4) (board 6) (board 2))))

	
(defn print-board []
	(println )
	(println (board 0) " | " (board 1) " | " (board 2))
	(println "---------------")
	(println (board 3) " | " (board 4) " | " (board 5))
	(println "---------------")
	(println (board 6) " | " (board 7) " | " (board 8))
	(println )
 	(println "Move Counter: " counter))


(defn play-move
  [spot who]
  
  (cond
    (and (< spot 0) (> spot 8)) false 
    (not (= " " (get board spot))) false  
    true (let [new-board (assoc board spot who)]
           (def board new-board )
           (def counter (+ counter 1)))))

    

    
(defn play-game
  []
  (cond 
    (and (<= counter 9 ) (is-winner? "X")) (println  "X is the winner")
    (and (<= counter 9 ) (is-winner? "O")) (println  "O is the winner")
    (>= counter 9) (println "No one is the winner")
    true (let [spot (read-line) 
        		who (read-line)]
    (play-move (read-string spot) (clojure.string/upper-case who))
    (print-board)
    (println "Type spot then who is playing")
    (play-game))))
