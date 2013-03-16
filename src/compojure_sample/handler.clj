(ns compojure-sample.handler
  (:use compojure.core)
  (:use ring.middleware.json)
  (:use ring.util.response)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
			[compojure-sample.model :as model]
			[compojure-sample.views :as view]))	
						
(defroutes app-routes
  (GET "/" [] 
    (view/index (model/get-hero-names)))
  
  (wrap-json-response 
	(GET "/hero/:name" [name] 
      (response (model/get-facts name))))
  (POST "/hero/:name" [name]
	"hola caracola")
  (route/files "/public" {:root "public"})
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
