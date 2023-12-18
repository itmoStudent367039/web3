import {Graph, Point} from "./Graph";

interface SuperWindow extends Window {
    drawGraph?: (points: Point[], radius: number) => void;
}

declare const window: SuperWindow;

window.drawGraph = (points: Point[], radius: number) => {
    GRAPH.redrawAll(radius);
    points.forEach(point => GRAPH.drawPoint(point));
};

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

const GRAPH: Graph = new Graph();

function watchClicking(event: MouseEvent): void {

    const x: number = ((7 / GRAPH.SIZE) * (event.offsetX - GRAPH.SIZE / 2));

    const y: number = ((7 / GRAPH.SIZE) * (GRAPH.SIZE / 2 - event.offsetY));

    // @ts-ignore
    addAttempt([{name: "x", value: x.toString()}, {name: "y", value: y.toString()},])
}

GRAPH.canvas.onmousedown = watchClicking;

// @ts-ignore
document.addEventListener('DOMContentLoaded', initGraph)
