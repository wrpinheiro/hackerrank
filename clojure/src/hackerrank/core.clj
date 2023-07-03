(ns hackerrank.core
  (:gen-class))

(load "mathematics/combinatorics/lexicographic-paths")

(defn -main [& args]
  (def t (Integer/parseInt (read-line)))
  (execute-t-cases t))
