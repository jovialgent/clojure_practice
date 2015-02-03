(ns clojure1.core-test
	(:require [clojure.test :refer :all]
		[clojure1.core :refer :all]))

(let [L '(0 1 2 3 4 5)
      L-str '("Adam" "Betty" "Carlos" "David" "Edwin" "Fred")
      L-mixed '("Apple" (0 1 2 3) 4 "Davis" ((0 2 3) 4) "Andrew")
      L-str-pair '("Adam" "Betty" "Carlos" "David" "Edwin" "Freddy")
      L-pair '(1 2 3 4 5 6)
      L-mixed-pair '("Apple" (0 1 2 3) 5 "Angela" ((0 2 3) 4) "Andrew")]
	
 	(deftest test-delete-at
		(testing "Remove First Element when i = 0"
			(is (= '(1 2 3 4 5) (delete-at L 0))))
		(testing "Remove last element when i = count(L) - 1"
			(is (= '(0 1 2 3 4) (delete-at L ( - (count L) 1)))))
		(testing "Remove index 2 when i=2"
  			(is (= '(0 1 2 3 5) (delete-at L 4))))
  		(testing "Remove non numbers"
      		(is (= '("Adam" "Betty" "Carlos" "Edwin" "Fred") (delete-at L-str 3))))
  	)
 	
  	(deftest test-delete-all-at
    	(testing "Return the list if no arguments given"
       		(is (= L (delete-all-at L))))
      (testing "If list is empty, return an empty list"
          (is (empty? (delete-all-at '() 0 1 2 3 4))))
      (testing "If any index is more than the count of this list, return L"
          (is (= '(0 1 3) (delete-all-at L  2 4 5 99))))
     	(testing "If all args are negative, return list"
        	(is (= L (delete-all-at L -1 -2 -3 -4))))
    	(testing "Remove the first element with args being 0"
       		(is (= '(1 2 3 4 5) (delete-all-at L 0))))
     	(testing "Remove the first and second element with args being (0, 1)"
       		(is (= '(0 3 4 5) (delete-all-at L 1 2))))
      	(testing "Removing all the items returns an empty list"
         	(is (empty? (delete-all-at L 0 1 2 3 4 5))))
       	(testing "Removing items in non cardinal order"
          	(is (= '(1 3) (delete-all-at L  2 0 4 5))))
        (testing "Removing items non number"
          	(is (= '("Betty", "David") (delete-all-at L-str 2 0 4 5))))
        (testing "Removing items mixed"
          	(is (= '((0 1 2 3) "Davis") (delete-all-at L-mixed 4 5 2 0))))
    )
   
   	(deftest test-similar
       	(testing "Return an empty list if L1 or L2 are empty"
          	(is (empty? (similar (quote ) (quote )))))
        (testing "Return '(1 2 3 4 5) when pairing L with L-pair"
          	(is (= '(1 2 3 4 5) (similar L L-pair))))
        (testing "Return an empty list if none match"
          (is (empty? (similar L L-str))))
        (testing "Returns '(Apple (0 1 2 3) ((0 2 3) 4) Andrew) in mixed lists"
          (is (= '("Apple" (0 1 2 3) ((0 2 3) 4) "Andrew") (similar L-mixed L-mixed-pair))))
   	 )
    
    
    
    (deftest test-has-el?
      (testing "Has el returns true for 0 in list (0 1 2 3)"
        (is (= true (has-el? 0 '(0 1 2 3 4 5)))))
      )
    
    (deftest test-mcons
      (testing "If no arguments, return empty list"
        (is (empty? (mcons))))
      (testing "If one argument that is a list, return list"
        (is (= '(d e) (mcons '(d e)))))
      (testing "If one argument that is not a list, return that element in a list"
        (is (= '("d") (mcons "d"))))
      (testing "If two arguments with last being a list, return one list with all elements"
        (is (= '(a b c) (mcons 'a '(b c)))))
      )
    (deftest test-invert
      (testing "If no arguments, return empty list"
        (is (empty? (invert '()))))
      (testing "If odd number of arguments, return -1"
        (is (= -1 (invert '(a b c d e)))))
      )
)






