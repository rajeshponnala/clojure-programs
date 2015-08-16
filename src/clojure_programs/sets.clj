(ns clojure-programs.sets
  (:gen-class))

(def emptySet
  (set '()))

(def setCount
  (count #{1 2 3}))

(def setUnion
  (clojure.set/union #{1 2 3 4} #{2 3 5}))
