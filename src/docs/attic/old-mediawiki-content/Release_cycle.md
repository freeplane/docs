<!-- toc -->

Freeplane's release cycle is time boxed at 6-9 months, and meant to allow for 1-2 stable releases per year (but much more unstable releases ;-) ).

![](Freeplane_Release_model.png ':size=800')

As shown above, the release cycle of Freeplane consists of 3 phases:

## Alpha
3-6 months of "wild" development on trunk branch<br>

* Branch the next release e.g. Branch_1.0.x - developers can continue to bring in new features on MAIN/HEAD/trunk.
&rArr; The phase ends when release branch is created from the trunk<br>

### Preview snapshots
Preview versions can be uploaded to a [preview area](https://www.freeplane.org/preview/).

Before downloading and trying the preview versions read and accept these warnings:

* They are not intended for any productive use.
* There is no support for them.
* Data format and properties may be changed for preview versions without any notice.
* Files and user properties saved by the preview versions may be not properly handled by any previous or following program versions.

## Unstable
3 months of bug fixing releases on the release branch
### Beta
2 months of bug fixing releases on Branch_1.0.x - that would be Beta releases.<br>
&rArr; Create RC1 (Release Candidate) - call for translations, 3rd party plugins and packaging.
### Release Candidate (RC)
1 month of integration of translations + critical bug fixing
&rArr; The phase ends when stable release is created, e.g. 1.1.0.
### Test releases
Test releases will be uploaded first to a testing area https://www.freeplane.org/testversion/  and can be released on https://sourceforge.net/projects/freeplane/files/freeplane%20beta/ 4-7 days later after one or more tester confirms that no major bugs have been introduced in the test version.


## Stable
final packaging can only happen after final release so we can only make sure that it all happen in a limited timeframe).<br>
new bug fixing / stable releases can be done as required, called 1.1.1, 1.1.2...<br>

The stable versions can be published on page https://sourceforge.net/projects/freeplane/files/freeplane%20stable/.<br>
They appear on page https://www.freeplane.org/testversion/ 4-7 days earlier.


Another way to show the approach is the following 3 pictures. The blue line turns clockwise while we progress through a release cycle; what is right of the line (in Green) is allowed to be done, what is left of the line (in Red) isn't.
This means that everything is allowed during Alpha phase, that in Beta we should avoid major rewrite unless it's needed to fix a critical bug, and, as we come to RC, almost nothing is allowed but to fix critical bugs.
; Side note: the line progresses continuously, it's not a sudden jump, e.g. during beta, we implement always less new things, even if they're easy to do, and fix always more bug, thus regularly stabilizing the code basis.

![Alpha phase](Freeplane_Release_Cycle_Alpha.png ':size=350')![Beta phase](Freeplane_Release_Cycle_Beta.png ':size=350')![Release Candidate phase](Freeplane_Release_Cycle_RC.png ':size=350')

## Bug handling

Freeplane uses the Sourceforge/Allura ticket system as bug tracker (https://sourceforge.net/p/freeplane/bugs/). Bugs should be set to resolved once the developer has fixed it and checked-in the changes in the version tool. The bug should be kept open to allow testers to alert the developers of a recurrence. The bugs can be closed in RC phase.

<!-- ({Category:Coding}) -->

