# MNIST with Tolerance Maps (WIP)

The very nature of the *digital* world requires absolute perfection &ndash;
when a single bit is off, whole systems can fail. In the *real* world we
say, "close enough" and we move on. Houses are built, cars assembled,
rockets launched, and financial transactions executed all within some
degree of tolerance.

In the world of *machine learning*, the science of statistics is used
with a given set of samples to derive a set of probabilities that
another sample is of a certain category &ndash; something akin to a
tolerance.

This project is an exploration of how much of an advantage
tolerance maps can provide in the speed and accuracy of
machine learning systems.

## MNIST

This project is meant to explore tolerance, we use
[MNIST](http://yann.lecun.com/exdb/mnist/) because it is
a well known and well researched machine learning database
of 60,000 handwritten digits.

<center><label>![](https://github.com/KeithPinson/MNIST-with-Tolerance-Maps/blob/master/Resources/mnist-sample.jpg?raw=true)<br/>
Sample of MINST digits<label></center><br/>

Each digit in the database has been normalized to roughly
the same size and centered on a grid of 28x28 pixels.

<center><label><img width="500px" src="https://github.com/KeithPinson/MNIST-with-Tolerance-Maps/blob/master/Resources/mnist_input_0.gif?raw=true" /><br/>
Anti-aliased gray-scale digit<label></center><br/>

The best machine learning methods are about 9,973 correct out
10,000. It is thought human accuracy is about 9,980 out of
10,000 for the MNIST test dataset.

Typically a supervised machine learning system would take all the
training data labeled as a number 5 and construct a prediction model
based on a location in the grid and its gray-scale values. Sounds
kind of like a table of tolerances; maybe a tolerance map will offer no
advantage?

## A Tolerance Map

In computer graphics a gray-scale image is often used as a
fast way to give a flat surface some dimensionality so that
light rays can be reflected more realistically off the
surface. Each pixel, rather than representing a color,
represents a height.

With a tolerance map, each pixel in the image represents
a tolerance: from no-tolerance (no ink should be here) to
high-tolerance (highly probable ink will be here).

For the MNIST test dataset, a test digit that matches closest
to a particalar tolerance map, is then presumed to be that
particular digit.

<table><tr><td>
<center><label><img src="https://github.com/KeithPinson/MNIST-with-Tolerance-Maps/blob/master/Resources/mnist_input_0-3d.png?raw=true"/><br/>
3D representation of MNIST input #0, the number 5<label></center>
</td><td>
<center><label><img src="https://github.com/KeithPinson/MNIST-with-Tolerance-Maps/blob/master/Resources/mnist_input_0_tolerance-3d.png?raw=true"/><br/>
3D representation of a tolerance map for the number 5<label></center>
</td></tr></table>


<center><label>![](https://github.com/KeithPinson/MNIST-with-Tolerance-Maps/blob/master/Resources/mnist_input_0-tolmap-animated.gif?raw=true)<br/>
3D tolerance map animated to better see its heights<label></center><br/>
