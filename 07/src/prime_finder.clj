(require '[clojure.math.numeric-tower :as math])

(defn notDivisible [dividend divisor]
  (not (= (mod dividend divisor) 0)))

(defn isPrime
  ([number] (isPrime number (range 2 number)))
  ([number smaller-primes]
   (if (< number 2)
     false
     (if (= number 2)
       true
       (let [root (math/sqrt number)]
         (every? #(notDivisible number %) (take-while
                                           #(< % (+ 1 root))
                                           smaller-primes)))))))

(defn filter-using-past-results 
  ([validator collection] (filter-using-past-results validator collection []))
  ([validator collection past-results]
   (let [n (first collection) remaining (rest collection)]
     (if (validator n past-results)
       (cons n (lazy-seq (filter-using-past-results validator
                                                    remaining
                                                    (conj past-results n))))
       (lazy-seq (filter-using-past-results validator remaining past-results))))))

(defn primes [] (filter-using-past-results isPrime (range)))

(defn nth-prime [n]
  (nth (into [] (take n (primes))) (- n 1)))

(time (nth-prime 10001))

(isPrime 1)
(isPrime 2)
(isPrime 3)
(isPrime 4)
(isPrime 5)
(isPrime 6)
(isPrime 7)
(isPrime 8)
(isPrime 9)
