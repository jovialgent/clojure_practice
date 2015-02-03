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
       		(is (= '(2 3 4 5) (delete-all-at L 0 1))))
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
    
    
    (defn print-test
       [description
        initial
        expected
        call
        actual
        & args
       ]
      
      
      (println "\nTesting: " description "\n")
      (println "L (or args)=" initial)
      (when (not (empty? args)) (println "L2="(first args)))
      (println "Expected Value:" expected)
      (println "Function Call:" call)
      (println "Actual Value:" actual "\n")
    )
    
    
    
    (println "\nTests For delete-at")
    (print-test "Determines if first element is removed" L '(1 2 3 4 5) '(delete-at L 0) (delete-at L 0)) 
    (print-test "Determines if last element is removed" L '(0 1 2 3 4) '(delete-at L (- (count L) 1)) (delete-at L (- (count L) 1))) 
    (print-test "Determines if element is removed at index i" L '(0 1 3 4 5) '(delete-at L 2) (delete-at L 2)) 
    (print-test "Determines if removed from mixed elements" L-mixed '("Apple" (0 1 2 3) "Davis" ((0 2 3) 4) "Andrew") '(delete-at L 2) (delete-at L-mixed 2)) 
    
    (println "\nTests For delete-all-at")
    (print-test "Determines if all args are negative return L" L L '(delete-all-at L -1 -2 -3) (delete-all-at L -1 -2 -3))
    (print-test "Remove first element if only one arg and its zero" L '(1 2 3 4 5) '(delete-all-at L 0) (delete-all-at L 0))
    (print-test "Remove any element if only one arg and its non-zero" L '(0 1 3 4 5) '(delete-all-at L 2) (delete-all-at L 2))
    (print-test "Remove any number of elements matching args" L '(0 1 5) '(delete-all-at L 2 3 4) (delete-all-at L 2 3 4))
    (print-test "Remove any number of mixed elements matching args" L-mixed '(Apple (0 1 2 3) Andrew) '(delete-all-at L 2 3 4) (delete-all-at L-mixed 2 3 4))
    (print-test "Return an emply list if all elements are in args" L '() '(delete-all-at L 0 1 2 3 4 5) (delete-all-at L 0 1 2 3 4 5))
    
    (println "\nTests For similar")
    (print-test "Return an empty list if there are no elements in either" L '() '(similar L ()) (similar L '()) '())
    (print-test "Return an empty list if non match" L '() '(similar L L2) (similar L L-str) L-str)
    (print-test "Return a list containing similar elements", L '(1 2 3 4 5) '(similar L L2) (similar L L-pair) L-pair)
    (print-test "Return a list containing similar mixed-elements", L-mixed '("Apple" (0 1 2 3) ((0 2 3) 4) "Andrew") '(similar L L2) (similar L-mixed L-mixed-pair) L-mixed-pair)
    
    (println "\nTests for alone")
    (print-test "Return an empty list if there are no elements in either" '() '() '(alone '() ()) (alone '() '()) '())
    (print-test "Returns List L if list L2 is empty" L L '(alone L '()) (alone L '()) '())
    (print-test "Returns List L2 if list L is empty" '() L '(alone '() L2) (alone '() L) L)
    (print-test "Returns a list of elements in one or the other, but not both", L '(0 6) '(similar L L2) (alone L L-pair) L-pair)
    (print-test "Returns a list of mixed elements in one or the other, but not both", L-mixed '(4 Davis 5 Angela) '(alone L L2) (alone L-mixed L-mixed-pair) L-mixed-pair)
    
    (println "\nTests for mcons")
    (print-test "Return list if only argument" '('(0 1 2)) '(0 1 2) '(mcons '(0 1 2)) (mcons '(0 1 2)))
    (print-test "Returns list with one elements to the left cons to the list" '(3 '(0 1 2)) '(3 0 1 2) '(mcons 3 '(0 1 2)) (mcons 3 '(0 1 2)))
    (print-test "Returns list with many elements to the left cons to the list" '( 4 3 '(0 1 2)) '(4 3 0 1 2) '(mcons 4 3 '(0 1 2)) (mcons 4 3 '(0 1 2)))
    (print-test "Returns list with many mixed elements to the left cons to the list" '( Apple 3 '(0 1 2 3) '(0 1 2)) '(Apple 3 '(0 1 2 3) 0 1 2) '(mcons Apple 3  '(0 1 2 3) '(0 1 2)) (mcons 'Apple 3 '(0 1 2 3) '(0 1 2)))
    
    (println "\nTests for invert")
    (print-test "Returns -1 if the list has odd number of elements" '(0 1 2) -1 '(invert '(0 1 2)) (invert '(0 1 2)))
    (print-test "Returns a swap on a list size of two" '(0 1) '(1 0) '(invert '(0 1)) (invert '(0 1)))
    (print-test "Returns a swap on any even list size" '(0 1 2 3 4 5 6 7 8 9 10 11) '(1 0 3 2 5 4 7 6 9 8 11 10) '(invert '(0 1 2 3 4 5 6 7 8 9 10 11)) (invert '(0 1 2 3 4 5 6 7 8 9 10 11)))
    (print-test "Returns a swap on any even list size with mixed elements" '(0 Apple 2 (0 1) Grape 5 (Andrew Ryan) Soda race car 10 11) '(Apple 0 (0 1) 2 5 Grape Soda (Andrew Ryan) car race 11 10) '(invert '(0 Apple 2 (0 1) Grape 5 (Andrew Ryan) Soda race car 10 11)) (invert '(0 Apple 2 (0 1) Grape 5 (Andrew Ryan) Soda race car 10 11)))
    

    
    )






