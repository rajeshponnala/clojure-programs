(ns clojure-programs.functions
  (:gen-class))



(defn square [n] (* n n))

(def inlineFunc
  ((fn [n] (* 10 n)) 2))

(def anonyFun
  (#(+ %1 %2 %3) 4 5 6))

(def highOrdFunc
  ((fn [f] (f 5))
   (fn [n] (* n n))))

(def highOrdExistFunc
  ((fn [f] (f 5)) square))

(defn transform
  [f data]
  (if (first data)
    (cons (f (first data))
          (transform f (rest data)))
    (list)))

(defn expand
  [f x count]
  (if (pos? count)
    (cons x (expand f (f x) (dec count)))
    (list)
    ))

(defn filter1 [f coll]
  (loop [c coll
         acc []]
    (cond (= c '()) acc
          (true? (f (first c))) (recur (rest c) (conj acc (first c)) )
          :else (recur (rest c) acc)
          )))

(defn is-prime?
  [n]
  (let [x (quot n 2)]
    (loop [i 2
           res true]
      (cond (zero? (mod n i)) false
            (> i x) res
            :else (recur(inc i)res)))))

(defn n-primes
  [n]
  (take n (filter is-prime? (iterate inc 1))))

(defn get-char-frequency
  [c word]
  (let [s (seq word)]
    (loop [w s
           cnt 0]
      (cond (nil? (first w)) cnt
            (= c (first w)) (recur (rest w) (inc cnt))
            :else (recur (rest w) cnt)))))

(defn filter2 [p coll]
  (for [ x  coll :when (p x)] x))

(defn last1 [coll]
  (loop [c coll]
    (let [[first & re] c]
      (cond (empty? re) first
            :else (recur (rest re))))))

(defn dropnthitem [n coll]
  (loop [c coll cnt 1 acc []]
    (cond (empty? c) acc
          (zero? (mod cnt n)) (recur (rest c) (inc cnt) acc)
          :else (recur (rest c) (inc cnt) (conj acc (first c))))))

(defn map-construct [keys values]
  (loop [k keys v values acc {}]
    (cond (or (empty? k) (empty? v)) acc
          :else (recur (rest k) (rest v) (conj acc [(first k) (first v)])))))

(defn map-defaults [val keys]
  (loop [k keys  acc {}]
    (cond (empty? k) acc
          :else (recur (rest k) (conj acc [(first k) val])))))


(defn max1 [coll]
  (reduce (fn [x y]
            (if (> x y) x y)) coll))

(defn is-perfect? [n]
  (= n (reduce (fn [x y] (if (zero? (mod n y)) (+ x y) x)) (range n))))

(defn read-data [filename]
  (clojure.string/split-lines (slurp (clojure.java.io/file "Latin-Lipsum.txt")))
  )

(defn index [e coll]
  (loop [c coll pos 0]
    (let [[first & re] c]
      (cond (= first e) pos
            (empty? re) -1
            :else (recur re (inc pos))))))
