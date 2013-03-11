(ns compojure-sample.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
			[compojure-sample.views :as view]))

(defroutes app-routes
  (GET "/" [] (view/index))
  (route/files "/public" {:root "public"})
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
