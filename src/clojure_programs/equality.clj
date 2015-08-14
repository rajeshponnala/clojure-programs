(ns clojure-programs
  (:gen-class))

(defn boolcheck
  []
  (= true true))

(def manyCheck
  (= (+ 3 4) (+ 2 5)))

(def checkManyForms
  (= 2 2/1))

(def strictCheck
  (= 2 2.0))

(def looseCheck
  (== 2 2.0))

(def notCheck
  (not= :fill-in-the-blank 123))
