(ns clojure-programs.refs
  (:gen-class))

(def the-world (ref "hello"))

(def derefworld
  (deref the-world))
