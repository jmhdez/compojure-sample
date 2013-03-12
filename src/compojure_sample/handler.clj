(ns compojure-sample.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
			[compojure-sample.model :as model]
			[compojure-sample.views :as view]))

(defroutes app-routes
  (GET "/" [] (view/index (model/get-hero-names)))
  (route/files "/public" {:root "public"})
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
