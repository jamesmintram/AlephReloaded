(defproject aleph-reloaded "0.1.0-SNAPSHOT"
  :dependencies 
  [
    [org.clojure/clojure        "1.8.0"]

     ;; Server
     [aleph "0.4.2-alpha1"]
     [bidi "2.0.10"]
     [aero "1.0.0-beta5"]

     ;; Logging
     [org.clojure/tools.logging "0.3.1"]
     [org.slf4j/jcl-over-slf4j "1.7.18"]
     [org.slf4j/jul-to-slf4j "1.7.18"]
     [org.slf4j/log4j-over-slf4j "1.7.18"]
     [ch.qos.logback/logback-classic "1.1.5"
      :exclusions [org.slf4j/slf4j-api]]]

  :plugins []

  :min-lein-version "2.5.3"

  :source-paths ["src/clj"]
  :resource-paths ["resources"]

  :profiles
  {:dev
   {:source-paths ["src/clj", "dev"]
    :dependencies [[reloaded.repl "0.2.3"]]
    :plugins      [[cider/cider-nrepl "0.13.0"]]
    }
  }
)
