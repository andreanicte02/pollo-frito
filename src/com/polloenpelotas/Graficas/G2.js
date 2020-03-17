var data = [{
title: "salida deseada",
values: [19, 26, 55],
labels: ["prueba1", "prueba2", "prueba3"],
type: 'pie' 
}];  
 
var layout = { 
height: 600, 
width: 600 
}; 
 
Plotly.newPlot('G2', data, layout);
