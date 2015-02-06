(ns clojure-assignment-2.core-test
  (:require [clojure.test :refer :all]
            [clojure-assignment-2.core :refer :all]))

(deftest test-predecessors
  (testing "See if example works"
    (is (=  (predecessors 'vapor_barrier_insulation tasks) '(roof install_windows_doors))))
  (testing "See if returns empty if no previous tasks"
  	(is (empty? (predecessors 'purchase_lot tasks)))))

(deftest test-gettime
	(testing "See if frame gets back 12"
		(is (= 12 (gettime 'frame tasks)))))

(deftest test-get_all_preds
	(testing "See if get_bids returns '(purchase_lot design_house)"
		(is (= #{ 'purchase_lot 'design_house} (get_all_preds 'get_bids tasks))))
	(testing "See if purchase_lot returns empty"
		(is (empty? (get_all_preds 'purchase_lot tasks))))
	(testing "See if ")
  )

(deftest test-precedes
	(testing "See if true for rough_electric precedes install_windows_doors"
		(is (true? (precedes 'rough_electric 'install_windows_doors tasks))))
  )
