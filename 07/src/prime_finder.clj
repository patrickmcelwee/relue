(require '[clojure.math.numeric-tower :as math])

(defn notDivisible [dividend divisor]
  (not ( = (mod dividend divisor) 0)))

(defn isPrime [number]
  (if ( < number 2)
    false
    (if ( = number 2)
      true
      (every? #(notDivisible number %) (range 2 (+ 1 (math/sqrt number)))))))

(defn primes
  ([] (primes 2))
  ([n] 
   (if (isPrime n)
     (cons n (lazy-seq (primes (inc n))))
     (lazy-seq (primes (inc n)))
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
