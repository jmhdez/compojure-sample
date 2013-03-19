(ns compojure-sample.model)

(def heroes (atom { 
    
    "Chuck Norris" 
    ["No existe la teoría de la evolución, tan sólo una lista de las especies que Chuck Norris permite vivir. "
      "Chuck Norris no te pisa un pie, sino el cuello."
      "Chuck Norris borró la papelera de reciclaje."] 

    "Bruce Scheneier"
    ["Science is defined as mankinds futile attempt at learning Bruce Schneiers private key."
     "Others test numbers to see whether they are prime. Bruce decides whether a number is prime."]

    "Arturo Pérez-Reverte"
    ["Pérez-Reverte se baja música en casa de Ramoncín."
     "Pérez-Reverte no necesita investigar para escribir novela histórica, el pasado cambia conforme teclea en la máquina."]}))

(defn get-facts [hero] 
  (get @heroes hero))

(defn add-fact! [hero fact]
  (swap! heroes update-in [hero] conj fact))

(defn get-heroes []
  (sort (keys @heroes)))