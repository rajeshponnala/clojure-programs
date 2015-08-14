(ns clojure-programs.lists
  (:gen-class))

(def getFirst
  (first '(1 2 3 4 5)))

(def getRest
  (rest '(1 2 3 4 5)))

(def consList
  (cons :a '(:b :c :d :e)))

(def conjList
  (conj '(:a :b :c :d :e) 0))

(def peekList
  (peek '(:a :b :c :d :e)))

(def popList
  (pop '(:a :b :c :d :e)))

(def popEmptyList
  (try
    (pop '())
    (catch IllegalStateException e "No dice!")))


(def restOfEmptyList
  (try
    (rest '())
    (catch IllegalStateException e "No dice!")))
