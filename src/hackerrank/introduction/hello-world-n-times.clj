(ns hackerrank.introduction.hello-world-n-times)

(fn [n]
  (loop [n])
    (str "Hello World")
    (recur (dec n)))
