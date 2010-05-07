(ns math.ClojureCalculator
  (:gen-class
   :implements [math.Calculator]))

(defn -add [this a b] (+ a b))
