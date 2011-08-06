(ns leiningen.herokujetty
  (require fs)
  (require [ring.adapter.jetty :as ring])
  (import (org.mortbay.jetty.webapp WebAppContext)))

(defn- create-war-handler [project]
  (let [handler (WebAppContext.)
        war (first (fs/glob (str (:root project) "/target/" (:name project) "*.war")))]
    (doto handler
      (.setContextPath "/")
      (.setWar war))
    handler))

(defn- nil-handler [req] nil)


(defn herokujetty 
  "Leiningen plugin to launch jetty instances inside Heroku"
  [project & args]
  (let [options {:port (Integer/parseInt (System/getenv "PORT"))
                 :configurator (fn [server] (.addHandler server (create-war-handler project)))}]
    (ring/run-jetty #'nil-handler options)))

