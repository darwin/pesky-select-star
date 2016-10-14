(defproject pesky-select-star "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"
  :dependencies [
                 ;[org.clojure/clojure "1.7.0"]
                 ;[org.clojure/clojurescript "1.7.122"]

                 [org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.229"]

                 [binaryage/devtools "0.8.2"]
                 [com.rpl/specter "0.13.1-SNAPSHOT"]]
  :jvm-opts ^:replace ["-Xmx1g" "-server"]
  :source-paths ["src"
                 "target/classes"]
  :clean-targets ["out" "release"]
  :target-path "target")
