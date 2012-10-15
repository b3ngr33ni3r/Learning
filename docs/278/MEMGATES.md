Comp278
=======

latch vs flipflop
-----------------
both store state.
Latches and flip-flops are the basic elements for storing information. One latch or flip-flop can store one bit of
information. The main difference between latches and flip-flops is that for latches, their outputs are constantly
affected by their inputs as long as the enable signal is asserted. In other words, when they are enabled, their content
changes immediately when their inputs change. Flip-flops, on the other hand, have their content change only either
at the rising or falling edge of the enable signal. This enable signal is usually the controlling clock signal. After the
rising or falling edge of the clock, the flip-flop content remains constant even if the input changes.


register storage
----------------
data is stored here before it is descended to the cpu, to be worked with.

[register file](http://en.wikipedia.org/wiki/Register_file)
--------------
stores the number of registers. all logic circuits have a count of registers.
ie: bits has 32 resistors, cause its a 32 bit os, and that's defined in the register file.
when accessing data registers, you need to specify the number of the register you want to write to
and the register command, and the data. This is how you write to the register. To read from it, 
you just need the register number you want to access, and it will give you all that data.
<pre>
                   *************
     read reg 1 -> * Register  *
     read reg2  -> * file      *
     write reg  -> *           * -> read data1
write data -\(n)-> *           * -> read data2
                   *           *
                   *************
</pre>
```add R1,R2,R3``` is whats trying to be shown above, because we have the requests to read the registers, and do the add, then store it to the other register


[Risc](http://en.wikipedia.org/wiki/Reduced_instruction_set_computing)
----
the type of machines that utilize registers most of the time, data is loaded into memory, and then operated on the registers.
the load and store are the only two commands (well, and variations) that actually use memory. they have lots of registers, like 64,32,128 etc.

[shift register](http://en.wikipedia.org/wiki/Shift_register)
--------------
shifts two data bits in a register left to right.
In digital circuits, a shift register is a cascade of flip flops, sharing the same clock, in which the output of each flip-flop is connected to the "data"
input of the next flip-flop in the chain, resulting in a circuit that shifts by one position the "bit array" stored in it, shifting in the data present at
its input and shifting out the last bit in the array, at each transition of the clock input. More generally, a shift register may be multidimensional, such
that its "data in" and stage outputs are themselves bit arrays: this is implemented simply by running several shift registers of the same bit-length in parallel.
Shift registers can have both parallel and serial inputs and outputs. These are often configured as serial-in, parallel-out (SIPO) or as parallel-in, serial-out
(PISO). There are also types that have both serial and parallel input and types with serial and parallel output. There are also bi-directional shift registers
which allow shifting in both directions: L?R or R?L. The serial input and last output of a shift register can also be connected to create a circular shift register.


you can learn more about flip flop circuits [here](http://en.wikipedia.org/wiki/Flip-flop_(electronics)).


convert the following to nand gate circuits:
--------------------------------------------
<pre>
~A ~C D + ~A ~B C + A ~B ~C + A ~B ~D

= NAND(NAND(~A ~C D) NAND(~A ~B C) NAND(A ~B ~C) NAND(A ~B ~D))
</pre>