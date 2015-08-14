(ns clojure-programs.vectors
  (:gen-class))

(def vectorCount
  (count [42]))

(def creVector
  (vec nil))


(def getFirst
  (first [:peanut :butter :and :jelly]))

(def getNth
  (nth [:peanut :butter :and :jelly] 3))

(def getSubVec
  (subvec [:peanut :butter :and :jelly] 1 3))

(def compVecWithColl
  (= '(1 2  3) [1 2 3]))
