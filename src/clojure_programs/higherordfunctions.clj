(ns clojure-programs.hfunctions
  (:gen-class))

(def mapEx
  (map (fn [n] (* 4 n))
       [1 2 3]))

(def mapSqEx
  (map (fn [n] (* n n))
       [1 2 3 4 5]))

(def mapBoolEx
  (map nil?
       [:a :b nil :c :d]))

(def filterStrong
  (filter (fn [x] false)
          '(:anything :goes :here)))

(def filterWeak
  (filter (fn [x] true)
          '(:anything :goes :here)))

(def filterbtw
  (filter (fn [x] (< x 40))
          [10 20 30 40 50 60 70 80]))

(def mapwithfilter
  (map (fn [x] (* x 10))
       (filter (fn [x] (< x 4))
               [1 2 3 4 5 6 7 8])))

(def reduceex
  (reduce (fn [a b] (* a b))
          [1 2 3 4]))

(def reduceWith
  (reduce (fn [a b] (* a b)) 100
          [1 2 3 4]))
(def reduceString
  (reduce (fn [a b] (if (< (count a) (count b)) b a))
          ["which" "word" "is" "longest"]))
