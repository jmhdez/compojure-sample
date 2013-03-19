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
    (view/index (model/get-heroes)))
 
  (GET "/hero/:name/facts" [name] 
    (response (model/get-facts name)))

  (POST "/hero/:name/facts" {{fact "fact"} :body, 
                             {name :name} :params} 
    (model/add-fact! name fact)
    (response {:status "OK"}))

  (route/files "/public" {:root "public"})
  (route/not-found "Not Found"))

(def app
  (handler/site (-> app-routes 
                    wrap-json-response 
                    wrap-json-body )))
