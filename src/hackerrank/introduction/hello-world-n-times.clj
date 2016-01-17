(ns hackerrank.introduction.hello-world-n-times)

(fn[n]
    (loop [iteration n]
        (if (> iteration 0)
            (do
                (println "Hello World")
                (recur (dec iteration))))))
