(ns clojure-assignment-2.core)

(def tasks '((purchase_lot 2)
 (design_house 5)
 (get_permit 1 purchase_lot design_house)
 (get_bids 14 purchase_lot design_house) 
 (select_subs 2 get_bids)
 (excavate 1 get_permit select_subs) 
 (construct_basement 7 excavate)
 (order_windows_doors 3 purchase_lot design_house) 
 (get_windows_doors 10 order_windows_doors)
 (frame 12 get_permit select_subs) 
 (rough_plumbing 5 frame)
 (rough_electric 3 frame)
 (roof 4 frame)
 (install_windows_doors 7 get_windows_doors rough_plumbing rough_electric)
 (vapor_barrier_insulation 2 roof install_windows_doors)
 (drywall 5 vapor_barrier_insulation)
 (inside_paint 3 drywall)
 (cupboards 3 inside_paint)
 (carpet_floor 5 inside_paint)
 (lights 2 inside_paint)
 (plumbing_heating 6 inside_paint)
 (siding 2 roof install_windows_doors)
 (outside_paint 3 siding)
 (move_house 1 cupboards carpet_floor lights plumbing_heating outside_paint)
 (connections 2 construct_basement move_house)
 (landscape 4 construct_basement move_house)
 (move_in 0 landscape connections)))

; Building a House



; sum - takes the list of tasks as an argument then returns the sum of all of the days needed for the individual jobs.

(defn sum 
	[L]
	(cond
		(empty? (rest L)) (second (first L))
		true (+ (second (first L)) (sum (rest L)))))

; predecessors - takes a specific job and the list of tasks then returns a list of the immediate predecessors for that job.
; (predecessors 'vapor_barrier_insulation tasks) should return

; (roof install_windows_doors)

(defn predecessors
	[task L]
	(cond
		(empty? L) false
		(= (first (first L)) task) (drop 2 (first L))
		true (predecessors task (rest L))))





; gettime - takes a job and the list of tasks then returns the time that job takes

(defn gettime
	[task L]
	(cond
		(empty? L) 0
		(= (first (first L)) task)  (second (first L))
		true (gettime task (rest L))))


; get_all_preds - takes a specific job and the list of tasks then returns a list of all of the predecessors for that job

(defn get_all_preds
	[task L]
	(cond
		(empty? L) false
		(= (first (first L)) task) (drop 2 (first L))
		true (set (flatten  (cons (drop 2 (first L)) (get_all_preds task (rest L)))))))



; precedes - takes two specific jobs and the list of tasks then returns true if the first job must precede the other and nil otherwise

(defn precedes
	[task1 task2 L]
	(cond
		(contains? (set (get_all_preds task2 L)) task1) true
		true nil))


; start_day - takes a specific job and the list of tasks then returns the day that this job can start
; get_max - takes a list of job names and the list of tasks then returns a list with the time and the job that finishes at the greatest time
; ==> (get_max '(frame roof select_subs) tasks)

; should return

; (37 roof)	;since roof cannot finish until day 37 (assuming the entire project started on day 1).

; Hint: #6 & #7 can be written as mutually recursive.

; critical_path - takes a job and the list of tasks then returns a list of the jobs on the critical path to getting this job done in the least amount of time
; depends_on - takes a job and the list of tasks then returns a list of the jobs that cannot be started until this job has completed. This should return all future jobs, not just the ones immediately affected.
; Deliverables:	Hand in your program and sample runs with the data file to show your functions perform properly. You are expected to provide an adequate test set.

; Grading:

; Problems 1-5	Maximum grade = 75
; Problems 1-7	Maximum grade = 85
; Problems 1-9	Maximum grade = 100
 
