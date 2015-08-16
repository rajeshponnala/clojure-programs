(ns clojure-programs.conditions
  (:gen-class))

(def ifC
  (if(false? (= 4 5))
    :a
    :b))

(def onlyIf
  (if (> 4 3)
    []))

(def nilCond
  (if (nil? 0)
    [:a :b :c]))
