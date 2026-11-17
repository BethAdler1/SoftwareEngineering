package project.api;

public class ComputationImpl implements ComputationAPI {
    
    @Override
    public ComputationResult performComputation(DataStream inputData, ComputationConfig config) {
        // Extract N number of trials from the data stream
        int n = 1000000; //default
        List<Integer> data = inputData.getData();
        if (data != null && !data.isEmpty()) {
            n = data.get(0); // read the first integer from the stream
        }
        // Run the Monte Carlo simulation trials
        long pointsInsideCircle = 0;
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            //generate random coordinates for x, y within the 1 x 1 square [0,1)]
            double x = random.nextDouble();
            double y = random.nextDouble();

            //Check if the point lies inside the quarter-circle of radius 1
            if (x * x + y * y <= 1) {
                pointsInsideCircle++;
            }
        }
        //Estimate Pi using the ratio formula
        double estimatedPi = (n > 0) ? 4.0 * ((double) pointsInsideCircle / n) : 0.0;

        //Return the result object
        return new ComputationResult()
        return null;
    }
}
