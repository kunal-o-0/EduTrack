import {
  Box,
  Card,
  CardContent,
  Divider,
  Paper,
  Stack,
  Typography,
} from "@mui/material";
import Styles from "../../assets/Style";
import { useEffect, useState } from "react";
import { createReceipt, getReceipts } from "../../services/student";

function PaymentDetails() {
  //  creating receipts state for storing all transactions
  const [receipts, setReceipts] = useState([createReceipt()]);

  const loadTransactions = () => {
    //  calling this function for fetching transactions details
    getReceipts(1).then((result) => {
      setReceipts(result);
    });
  };

  useEffect(() => {
    loadTransactions();
  }, []);

  return (
    <Paper
      sx={{ width: "60rem", bgcolor: Styles.colors.primary, height: "100%" }}
      elevation={0}
    >
      <Typography
        variant="h3"
        component="p"
        align="center"
        sx={{ position: "sticky", fontSize: "2.3rem", fontWeight: "500" }}
        gutterBottom
      >
        Payment Receipts
      </Typography>
      {/* creating multiple cards containing transactions details which are fetched into receipts state */}
      {receipts.map((receipt) => {
        return (
          <Card
            sx={{
              marginTop: "1rem",
              borderRadius: "1rem",
              maxHeight: "10rem",
            }}
            key={parseInt(receipt.id)}
          >
            <CardContent sx={{ padding: "0", ":last-child": { padding: "0" } }}>
              <Stack
                direction="row"
                spacing={1}
                sx={{ bgcolor: Styles.colors.secondary }}
              >
                <Box
                  sx={{
                    padding: "0.5rem",
                    width: "20rem",
                    bgcolor: Styles.colors.primary_dark,
                    color: Styles.colors.primary,
                  }}
                >
                  <Stack direction="column">
                    <Typography
                      variant="h5"
                      component="p"
                      align="center"
                      sx={{ fontWeight: "600" }}
                      gutterBottom
                    >
                      Amount
                      <br />₹ {receipt.amount}
                    </Typography>
                    <Divider
                      variant="fullWidth"
                      sx={{ bgcolor: Styles.colors.secondary }}
                    />
                    <Typography
                      variant="subtitle1"
                      align="center"
                      sx={{ fontSize: "1.1rem", marginTop: "0.5rem" }}
                    >
                      {receipt.feesType}
                    </Typography>
                  </Stack>
                </Box>
                <Box
                  sx={{
                    padding: "0.5rem",
                    width: "100%",
                    maxHeight: "10rem",
                    overflowY: "scroll",
                  }}
                >
                  <Typography
                    variant="h6"
                    component="p"
                    sx={{ color: Styles.colors.primary, fontSize: "1rem" }}
                  >
                    ID: {receipt.id}
                    <br />
                    Date & Time: {receipt.timestamp}
                    <br />
                    Details: {receipt.details}
                    <br />
                  </Typography>
                </Box>
              </Stack>
            </CardContent>
          </Card>
        );
      })}
    </Paper>
  );
}

export default PaymentDetails;
