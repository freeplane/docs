<!-- toc -->

## Description of Vulnerability
A malicious mind map containing scripts or formulas can be used to escape the JVM sandbox and take full control over the victim's computer by leveraging Groovy to violate Java's access modifiers and disable the Security Manager. We recommend all our users to upgrade to the latest version as soon as possible.

Reported on 2017/02/19

Fix released on 2017/04/15

## Severity
The CVSS score of this vulnerability is 7.8, based on vector [AV:L/AC:L/PR:N/UI:R/S:U/C:H/I:H/A:H](https://nvd.nist.gov/vuln-metrics/cvss/v3-calculator?vector=AV:L/AC:L/PR:N/UI:R/S:U/C:H/I:H/A:H).

## Affected Versions
1.5.19 and prior

1.6.1_16 and prior

## Fixed Versions
1.5.20

1.6.1_17

## Acknowledgments
We would like to thank [Adrián Bravo Navarro](https://www.linkedin.com/in/adrianbn) ([@adrianbravon](https://twitter.com/adrianbravon) ) for his research and help throughout reporting and fixing this issue.

<!-- ({Category:Security}) -->

