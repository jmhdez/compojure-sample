(ns compojure-sample.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
			[compojure-sample.model :as model]
			[compojure-sample.views :as view]
			[clj-json.core :as json]))

(defn json-response [data & [status]]
  {:status (or status 200)
   :headers {"Content-Type" "application/json"}
   :body (json/generate-string data)})		
			
(defroutes app-routes
  (GET "/" [] 
    (view/index (model/get-hero-names)))
  (GET "/hero/:name" [name] 
    (json-response (model/get-facts name)))
  (route/files "/public" {:root "public"})
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
