;; George Petersen
;; 2/3/2014
;; 
;; This is all the answers and code for assignment for 
;; CS 3210: Principles of programming languages. 



(ns clojure1.core)

;; ================
;; Helper Functions
;; ================


(defn has-el?
  
  "Determines if an element is in a list"
  
  [el  ;; el - element to check for in this list 
   L]  ;; L - list to see if it is contained
  
  ;; Checks to see if this list is empty indicating this list
  ;; doesn't have this element. If the element is the first
  ;; of this list matches the element and if so returns true.
  ;; If there are still elements in this list, it calls
  ;; the function until one of the previous conditions are
  ;; met.
  (cond 
    
    ;; If L is empty, this implies no elements matched and
    ;; so return false indicating no elements fit.
    (empty? L) false
    
    ;; If el equals the first in list L, return true 
    ;; indicatin that this list contains an element
    (= el (first L)) true
    
    ;; Finally, recursively call has-el? until all
    ;; elements in the list are checked.
    true (has-el? el (rest L))))

(defn remove-el
  
  "Removes an element from a list"
  
  [el  ;; el - Element to be removed this list
   L]  ;; L - List to have an element removed
  
  ;; Checks to see if this list is empty and if so
  ;; returns an empty list. If this element matches
  ;; the first element in this list, return rest
  ;; of this list. Otherwise, construct a list that
  ;; this call builds with the rest of this list.
  (cond 
    
    ;; If list is empty, return this empty list.
    (empty? L) '()
    
    ;; If this element matches the first element in
    ;; this list, return the rest of this list.
    (= el (first L)) (rest L)
    
    ;; Finally, if there is no match and the list
    ;; is not empty, recursively call remove-el
    ;; on this element and the rest of this list
    true (cons (first L)  (remove-el el (rest L)))))




(defn mcons-helper
  "Performs this mcons function on a list."
  [L] ;; L - list to perform mcons on
  
  ;; Checks to see if the rest of this list is not 
  ;; empty and checks to see if this first element
  ;; is not a list to make a list so it adds it.
  ;; If the rest of this list is empty, returns
  ;; the first element of this list which the 
  ;; rest of this list will be added. Lastly
  ;; constructs the return list and recursively
  ;; calls mcons-helper on the rest of this List
  (cond 
    
    ;; If this list is empty and the last element
    ;; is not a list, create a list with this
    ;; element and return it.
    (and 
      (empty? (rest L)) 
      (not (list? (first L)))) (cons (first L) '())
    
    ;; If this list is empty and the first element
    ;; return this list to be consed with the list
    ;; being constructed by previous calls.
    (empty? (rest L)) (first L)
    
    ;; Finally, just construct a list and call 
    ;; mcons-helper on the rest of this list.
    true (cons (first L) (mcons-helper (rest L)))))

(defn invert-helper
  "Inverts every other element in this list. This does 
  so by checking whether i is odd or even. If odd, 
  cons the first element to the return list. If even, 
  return the first of the rest of this list and the 
  rest of the rest of the following list."
  [L  ;; L - list of elements to invert. 
   i] ;; i - index indicating which element to
      ;; move.
  
  ;; If this list is empty, return an empty list. 
  ;; If i is odd, add the first element of L and
  ;; call invert-helper on the rest of this list
  ;; and add one to i. If i is even, cons the 
  ;; first element of the rest of this list and then
  ;; call invert-helper on a list that removes the
  ;; second element of this list and adds one
  ;; to the index.
  (cond 
    
    ;; If this list is empty, return an empty list.
    (empty? L) '()
    
    ;; If i is odd, return the first element and
    ;; call invert-helper on the rest of L and increase
    ;; i by one.
    (odd? i) (cons (first L) 
               (invert-helper (rest L) (+ i 1)))
    
    ;; If i is even, return the first of the rest of
    ;; the list (2nd element) and then call invert-helper
    ;; on a list without this element and increase the
    ;; index i by 1
    (even? i) (cons 
                (first (rest L)) 
                (invert-helper 
                  (cons (first L) 
                    (rest (rest L))) (+ i 1)))))



;; ======================
;; Functions to be graded
;; ======================


(defn delete-at
  
  "Removes an element from list L at index i and returns 
  this new list with this element removed."
  
  [L  ;; L- List to have elements removed
   i] ;; i - index of element to be removed
        
  ;; This navigates the recursive call. It will first make sure no 
  ;; index is negative. Then goes with a base case and then 
  ;; performs the recursive call for delete-at.     
  (cond 
    
    ;; Checks to see if this index is negative, then return this 
    ;; list without any element removed from this list.
    (< i 0) L
    
    ;; If this index is zero, this will return this rest of 
    ;; this list thereby returning this list without this 
    ;; element given. 
    (= i 0) (rest L)
    
    ;; Calls this delete-at recursively and cons the first 
    ;; element to this list being built by these recursive 
    ;; calls.
    true (cons (first L) (delete-at 
                           (rest L) 
                           (- i 1)))))


(defn delete-all-at
  
  "Removes all elements from this list L at indices in 
  these arguments following this list." 
  
  [L        ;; L- List of elements
   & args]  ;; All other arguments which are the indices 
            ;; to remove
  
  ;; Tests and runs this delete-all-at function. First this 
  ;; will make sure the first element in the args is not a 
  ;; list and perform priliminary tests. If this argument's 
  ;; first element is a list, this will do secondary tests
  ;; with these arguments like a list. 
  (cond
    
    ;; If these arguments' first element is not a 
    ;: collection (implying that these arguments haven't been 
    ;; changed to a list) then it performs priliminary 
    ;; tests.
    (not (coll? (first args))) 
    
      ;; Performs preliminary tests such as making sure 
      ;; there are arguments in the list and also that none 
      ;; of the arguments are negative.
    	(cond
       
        ;; If there are no arguments, return this original
        ;; list.
        (nil? args) L
        
        ;; If there are any args that are negative then
        ;; return this original list. 
        (some neg? args) L
        
        ;; If list is empty, return this list empty
        (empty? L) '()
        
        ;; If there are any arguments equal to zero, this
        ;; will return the rest of list, L, removing this
        ;; first element and recursively call delete-all-at
        ;; for the rest of this list with each indices 
        ;; reduced by one.
        (some zero? args) (delete-all-at 
                            (rest L) 
                            (map #(- % 1) args))
        
        ;; Finally, if there are no zeros or negatives in 
        ;; this list of arguments, construct a new list
        ;; with the first element and call delete-all-at
        ;; recursively on the rest of this list.
        true (cons (first L) (delete-all-at 
                               (rest L) 
                               (map #(- % 1) args))))
    
    ;; After this initial call for this delete-all-at 
    ;; function, these arguments become a list due to the
    ;; mapping in the initial and subsequent calls. This
    ;; condition makes sure that there is not any 
    ;; conflict for the rest of these calls.
    (coll? (first args)) 
      
     	(let [args-temp (first args)] ;; args-temp- holds 
                                    ;; these indices in
                                    ;; a list.
        
        ;; This will check to see if this list needs to
        ;; remove this first element if there are any
        ;; zeros in the list of indices or if all
        ;; these numbers are negative, terminate this
        ;; call.  
        (cond
          
          ;; If list is empty, then return an empty
          ;; list.
          (empty? L) '()
          
          ;; If any of these indices are zero, call
          ;; delete-all-at on the rest of this list
          ;; without adding this first element. Then,
          ;; call delete-all-at on the rest of this 
          ;; list and reduce the indices by one.
          (some zero? args-temp) 
            (delete-all-at (rest L) 
              (map #(- % 1) args-temp))
          
          ;; If all elements are negative, return this 
          ;; list ending all these recursive calls.
          (every? neg? args-temp) L
          
          ;; Finally, if there is no conditonal met,
          ;; add this first list and call delete-all-at
          ;; on the rest of this list with all indices
          ;; reduced by one.
          true (cons (first L) (delete-all-at (rest L) 
                                 (map #(- % 1) 
                                   args-temp))))))) 

(defn similar
  
  "Returns a list of all elements of two lists that share
  an element between them."
  
  	[L1   ;; L1 - List of elements
      L2] ;; L2 - List of elements
   
   ;; Checks to first see if either list is not defined,
   ;; or empty and returns an empty list since either
   ;; condition has no shared elements. Then if there
   ;; exists an element in L1 that exists in L2, then
   ;; constructs a list with that element and the 
   ;; rest of L1 and all of L2 as its arguments for this
   ;; recursive call.
   (cond
     
     ;; If either list is nil, return an empty list
     (or (nil? L1) (nil? L2)) '()
     
     ;; If either list is empty, return an empty list
     (or (empty? L1) (empty? L2)) '()
     
     ;; If an element in L1 is in L2, then cons it to
     ;; the returning list and call similar recursively
     ;; on the rest of L1 and L2.
     (has-el? (first L1) L2) 
       (cons (first L1) (similar (rest L1) L2))
     
     ;; Finally, if there are no matches in either list,
     ;; call similar recursively without adding anything
     ;; to the resulting string.
     true (similar (rest L1) L2)
))

(defn alone
  
  "Compares two lists and returns a list of elements that
  is contained in one list or the other, but not both."
  
  	[L1  ;; L1 - List of elements
     L2] ;; L2 - List of elements
   
   ;; Checks first if both lists are nil implying that 
   ;; there are no elements the same. It will check to
   ;; see if either list is empty and if so, return the 
   ;; other list since if L2 is empty, only L1 is different
   ;; and if L1 is empty, this is the final state of this
   ;; recursive call. Never, if the first element is in
   ;; the second list, it calls the remove-el function and
   ;; removes that element from L2 and continues call this
   ;; function recursively. Finally, if there are no similars
   ;; this function will construct the list that will be
   ;; returned.   
   (cond
     
     ;; If both lists are not defined, return an empty
     ;; list.
     (and (nil? L1) (nil? L2)) '()
     
     ;; If L2 is empty, return all contents in L1 
     ;; indicating the unique values.
     (empty? L2) L1
     
     ;; If L1 is empty, this is the terminating 
     ;; case for this recursive function since
     ;; it process each element of L1 at a time.
     (empty? L1) L2
     
     ;; If the first element of L1 is in L2, then
     ;; call alone on the rest of L1 and L2 without
     ;; the element in L2.
     (has-el? (first L1) L2)  
       (alone (rest L1) (remove-el (first L1) L2))
       
     ;; Finally, if there is no similars, this will
     ;; add the first element to the resulting 
     ;; list that will be returned and call 
     ;; recursively alone on the rest of L1 and 
     ;; L2
     true (cons (first L1) (alone 
                             (rest L1) L2))))

(defn mcons
  "Performs a version of cons where every element
   is consed with the last element in this list."
   
  [& args]  ;; args - list of elements to mcons  
    
    ;; Checks to see if there are any arguments
    ;; if not then returns an empty list. Otherwise
    ;; perform the helper function for mcons.
    (cond 
      ;; If there no arguments, return an empty
      ;; list.
      (empty? args) '()
      
      ;; Since it was hard to perform recursive
      ;; calls on arguments, a helper function 
      ;; was built that takes the args as a list
      ;; and performs recursion. For more
      ;; documentation check out the documents
      ;; for the function mcons-helper.
      true (mcons-helper args)))

(defn invert
  
  "Inverts every two elements of an odd numbered list
  and returns this list."
  
  [L] ;; L - list of even numbered elements to be 
      ;; inverted.
      
   ;; This will check that if this list is not empty
   ;; and also that there are an even number of 
   ;; elements in this list. 
   (cond
     ;; If this list is empty, return this list.
     (empty? L) '()
     ;; If this list has an odd number of 
     ;; elements, return -1 indicating that
     ;; this list list has mismat elements.
     (odd? (count L)) -1
     
     ;; This calls this helper function if
     ;; all elements are met. This is helper
     ;; function keeps track of which elements
     ;; to invert. For more documentation,
     ;; read the documentation for this 
     ;; helper function called invert-helper.
     true (invert-helper L 0)))



            
