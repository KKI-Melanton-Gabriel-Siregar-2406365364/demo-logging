# Module 07 - Profiling and Logging Exercise

## Baseline Performance Testing (JMeter GUI)

Test configuration used for baseline:

- Endpoint: `/all-student`
- Threads (users): `10`
- Ramp-up: `1` second
- Loop count: `1`

### View Results Tree

![View Results Tree - all-student](docs/images/jmeter-all-student-view-results-tree.png)

### View Results in Table

![View Results in Table - all-student](docs/images/jmeter-all-student-view-results-table.png)

### Summary Report

![Summary Report - all-student](docs/images/jmeter-all-student-summary-report.png)

### Graph Results

![Graph Results - all-student](docs/images/jmeter-all-student-graph-results.png)

### /all-student-name (GUI)

Test configuration:

- Endpoint: `/all-student-name`
- Threads (users): `10` (target setting from module)
- Ramp-up: `1` second
- Loop count: `1`

#### View Results Tree

![View Results Tree - all-student-name](docs/images/jmeter-all-student-name-view-results-tree.png)

#### View Results in Table

![View Results in Table - all-student-name](docs/images/jmeter-all-student-name-view-results-table.png)

#### Summary Report

![Summary Report - all-student-name](docs/images/jmeter-all-student-name-summary-report.png)

#### Graph Results

![Graph Results - all-student-name](docs/images/jmeter-all-student-name-graph-results.png)

### /highest-gpa (GUI)

Test configuration:

- Endpoint: `/highest-gpa`
- Threads (users): `10`
- Ramp-up: `1` second
- Loop count: `1`

#### View Results Tree

![View Results Tree - highest-gpa](docs/images/jmeter-highest-gpa-view-results-tree.png)

#### View Results in Table

![View Results in Table - highest-gpa](docs/images/jmeter-highest-gpa-view-results-table.png)

#### Summary Report

![Summary Report - highest-gpa](docs/images/jmeter-highest-gpa-summary-report.png)

#### Graph Results

![Graph Results - highest-gpa](docs/images/jmeter-highest-gpa-graph-results.png)

## JMeter CLI Execution

### CLI - /all-student-name

![CLI Result - all-student-name](docs/images/jmeter-cli-all-student-name.png)

### CLI - /highest-gpa

![CLI Result - highest-gpa](docs/images/jmeter-cli-highest-gpa.png)

## Profiling and Refactoring

Refactoring focus:

- Reduce N+1 query pattern in `/all-student`
- Fetch names directly for `/all-student-name`
- Add DB index for GPA-related lookup path

### Profiler Comparison (Before)

![Profiler Before Refactor](docs/images/profiler-before.png)

### Profiler Comparison (After)

![Profiler After Refactor](docs/images/profiler-after.png)

### Conclusion

The second profiling capture shows lower CPU-time values than the initial capture, indicating improved runtime performance after refactoring.
