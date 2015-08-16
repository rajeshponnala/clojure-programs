(ns clojure-programs.rp
  (:gen-class))

(defn hello
  ([] "Hello World!")
  ([a] (str "Hello, you silly " a "."))
  ([a & more] (str "Hello to this group: "
                   (apply str
                          (interpose ", " (cons a more)))
                   "!")))
