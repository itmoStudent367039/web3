import {Graph} from "./graph";

(() => {
    const graphContainer = document.createElement('div');
    graphContainer.classList.add('graph-container');

    const canvas = document.createElement('canvas');
    canvas.id = 'graph';
    canvas.width = 300;
    canvas.height = 300;

    graphContainer.appendChild(canvas);
    const contentDiv = document.querySelector('.content');
    contentDiv.insertBefore(graphContainer, contentDiv.firstChild);
})();


const GRAPH = new Graph();

