(ns alephreloaded.ws-server
  (:require

   [clojure.tools.logging :refer :all]
   [com.stuartsierra.component :refer [Lifecycle using]]

   [aleph.http :as http]
   [manifold.stream :as s]))


(defn handler [req]
  (let [s @(http/websocket-connection req)]
    (s/connect s s)))


(defrecord WSServer [port
                     server]
  Lifecycle
  (start [component]
      (println "Start WS server on port " port)
      (if server 
         component
         
         (let [server (http/start-server handler {:port port :join? false})]
            (assoc component :server server))))

  (stop [component]
   (println "Stop WS server")
    (when-let [server (:server component)]
      (.close server))
    (assoc component :server nil)))

(defn new-ws-server []
  (using
   (map->WSServer {})
   []))