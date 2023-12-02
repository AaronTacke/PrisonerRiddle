# Benchmarking solutions to the prisoner riddle

Performance Check for well-known prisoner riddle with 100 prisoners and light bulb.

## [The Riddle](https://puzzles.nigelcoldwell.co.uk/seventyfourhint.htm):

There are 100 prisoners in solitary cells. There's a central living room with one light bulb; this bulb is initially
off. No prisoner can see the light bulb from his or her own cell. Everyday, the warden picks a prisoner equally at
random, and that prisoner visits the living room. While there, the prisoner can toggle the bulb if he or she wishes.
Also, the prisoner has the option of asserting that all 100 prisoners have been to the living room by now. If this
assertion is false, all 100 prisoners are shot. However, if it is indeed true, all prisoners are set free and inducted
into MENSA, since the world could always use more smart people. Thus, the assertion should only be made if the prisoner
is 100% certain of its validity. The prisoners are allowed to get together one night in the courtyard, to discuss a
plan. What plan should they agree on, so that eventually, someone will make a correct assertion?

## Solutions

Here the different solutions that I tested:

### The right solution: [MasterSlave](./MasterSlavePrisoner.java)

All slaves switch the light from off to on, if they have never done that before.

The master switches the light off and counts until he finds it turned on for the 99th time.

**This takes an average of 10416 days until the prisoners escape.**

### The complex solution: [CorrectDay](./CorrectDayPrisoner.java)

If the light is on on day x, this means that prisoners {0, ..., x mod 100} visited the room.

Only if the light is on, and prisoner i visits on the correct day (x mod 100 = i), he keeps it on.

As an optimization, all prisoners remember the maximum day (mod 100) where they saw the light turned on, and turn it on
on all days (mod 100) before.

**This takes an average of 6478764 days until the prisoners escape.**

### The best solution: [MachineLearning](./MachineLearningPrisoner.java)

Based on experience, all prisoners visited the room after 1000 days (with 99.6% accuracy).

**This takes an average of 1000 days until the prisoners (hopefully) escape.**
