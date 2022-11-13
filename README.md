# Concurrent infinite series
Concurrent solutions for the calculation of the Euler's number through an infinite series using threads.

# Build and run
In the src directory<br>
`$ javac fileName.java`<br>
`$ java fileName -nterms n`<br>
where n is the number of terms to be calculated for the summation.

For the fixed version (FixedThreads.java) the number of requested threads must be specified with the `-nthreads` parameter, so the execution would be<br>
`$ java fileName -nterms n -nthreads k`<br>
where k is the number of threads.

# Authors
- [Paulo Vitor Fernandes Andrade](https://github.com/PauloFAndrade)
- [Rita de Cássia Chagas da Cruz](https://github.com/rcchcz)
