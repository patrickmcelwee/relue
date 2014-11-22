(require '[clojure.math.numeric-tower :as math])

(defn notDivisible [dividend divisor]
  (not ( = (mod dividend divisor) 0)))

(defn isPrime
  ([number] (isPrime number (range 2 number)))
  ([number candidates]
   (if ( < number 2)
     false
     (if ( = number 2)
       true
       (every? #(notDivisible number %) (take-while
                                          #(< % (+ 1 (math/sqrt number)))
                                          candidates) ))))
  )

(defn primes
  ([] (primes 3 [2]))
  ([n alreadyPrimes] 
   (if (isPrime n alreadyPrimes)
     (cons n (lazy-seq (primes (inc n) (conj alreadyPrimes n))))
     (lazy-seq (primes (inc n) alreadyPrimes))
     )
   )
  )

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
