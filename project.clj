(defproject lein-herokujetty "0.1.0"
  :description "Leiningen plugin to launch jetty instances inside Heroku"
  :dependencies
    [[org.clojure/clojure "1.2.1"]
     [org.clojure/clojure-contrib "1.2.0"]
     [fs "0.8.1"]
     [ring/ring-jetty-adapter "0.3.10"]
     [org.mortbay.jetty/jsp-2.1-jetty "6.1.26"]]
  :eval-in-leiningen true)

